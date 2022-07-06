// Import required classes
import java.util.Properties;
import java.io.InputStream;
import com.boomi.execution.ExecutionUtil;

// Retrieve current Dynamic Process Property value
counter = ExecutionUtil.getDynamicProcessProperty("Offset DPP");

// Convert String value to Integer to do math
int intValue = Integer.parseInt(counter);

// Increment value by 100
intValue = intValue + 100;

// Convert Integer value back to String
counter = Integer.toString(intValue);

// Set the Dynamic Process Property without persisting the value
ExecutionUtil.setDynamicProcessProperty("Offset DPP", counter, false);

// Pass documents through
for ( int i = 0; i < dataContext.getDataCount(); i++ ) {
  InputStream is = dataContext.getStream(i);
  Properties props = dataContext.getProperties(i);
  dataContext.storeStream(is, props);
}