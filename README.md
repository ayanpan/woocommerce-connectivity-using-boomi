# WooCommerce Connectivity using Boomi

## Introduction
WooCommerce is a customizable, open-source eCommerce platform built on WordPress. It can store Customer, Order, Product, Coupons, and various other details related to eCommerce operations and transactions.

The objective of this document is to show the WooCommerce configurations which are required to get it connected with Boomi to synchronize records with various other applications.


## Configure WooCommerce to Generate Key-Secret Pair

**Step-1:** Go to WooCommerce  Settings  Advanced.

![image](https://user-images.githubusercontent.com/12267939/177543417-9f106ff0-911f-44d2-8c7e-1b30927e125d.png)

**Step-2:** Click “REST API”, and then click “Add Key”.

![image](https://user-images.githubusercontent.com/12267939/177543457-addfb5cb-03e7-4464-bdb3-be67960b0539.png)


**Step-3:** Add values for “Description”, “User”, and “Permissions”, and then click “Generate API key”.

![image](https://user-images.githubusercontent.com/12267939/177543470-406b96cd-b5b9-4be2-a726-9e2b6e81b5c7.png)


**Step-4:** Make note of “Consumer key” and “Consumer secret” values, as they will be hidden once you leave this page.

![image](https://user-images.githubusercontent.com/12267939/177543486-168f483e-50e1-4d8f-b18a-d66ccd929d3c.png)


**Step-5:** New user/connection is now visible in the “REST API” section.

![image](https://user-images.githubusercontent.com/12267939/177543506-0c861629-486d-4e23-be66-e55a5fdac39b.png)


## Configure Boomi Connection

Set Base-URL in “URL” field.

![image](https://user-images.githubusercontent.com/12267939/177543537-5738e146-3ee8-43d8-b1b6-139434a8c26d.png)


## Configure Boomi GET Operation
Set Request Headers and Resource Path. 

![image](https://user-images.githubusercontent.com/12267939/177543555-9deb031d-eaef-425c-8d68-fb3e8c6c3e72.png)


## Configure Boomi SEND Operation for CREATE

Set Request Headers and Resource Path. 

![image](https://user-images.githubusercontent.com/12267939/177543593-d0674824-2cea-403b-8f08-c1aadf741f9e.png)


## Configure Boomi SEND Operation for UPDATE
Set Request Headers and Resource Path. 

![image](https://user-images.githubusercontent.com/12267939/177543655-5b671081-eda9-45ce-bc33-cfe6b47bf5c9.png)


## Implement Pagination in Boomi to Fetch Records from WooCommerce
Overall Boomi process to fetch records from WooCommerce using Pagination, and send the records to NetSuite.

![image](https://user-images.githubusercontent.com/12267939/177543688-6108b98c-580e-436c-93fd-12aa77b93d31.png)


**Step-1:** Set Initial Offset and Last Successful Run Date

![image](https://user-images.githubusercontent.com/12267939/177543721-78c4f33c-76da-46e5-a48e-4e60cb5bce71.png)


**Step-2:** Set WooCommerce connection.

![image](https://user-images.githubusercontent.com/12267939/177543745-9478ebc0-c9a2-4baa-954f-a43085d51e28.png)


**Step-3:** Set WooCommerce Operation

![image](https://user-images.githubusercontent.com/12267939/177543778-188bbe32-1e29-4cfe-b6ed-626c52c0ac5f.png)


**Step-4:** If record is fetched from WooCommerce, then proceed Branch-1 in “True” path, else stop the execution in “False” path.

![image](https://user-images.githubusercontent.com/12267939/177543799-523057e9-56c9-41e1-a3ab-a70d4d84bd0d.png)


**Step-5:** Once Branch-1 is successfully complete, increment offset counter by 100 in Branch-2 and loop back to WooCommerce connector until a record is available, using Groovy script (please refer "Increment Counter.groovy" file).
