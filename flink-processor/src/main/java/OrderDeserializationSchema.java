import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import org.apache.flink.api.common.serialization.AbstractDeserializationSchema;

public class OrderDeserializationSchema extends AbstractDeserializationSchema<Order> {
  private static final long serialVersionUUID = 1L;

  private transient ObjectMapper objectMapper;

  @Override
  public void open(InitializationContext context) {
    objectMapper = JsonMapper.builder().build().registerModule(new JavaTimeModule());
  }

  @Override
  public Orer deserialize(byte[] message) throws IOException {
    return objectMapper.readValue(message, Order.class);
  }
}