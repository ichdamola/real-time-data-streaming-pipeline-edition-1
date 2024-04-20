import java.util.Objects;

public class Order {

  /*
  {
    "cost": "New York",
    "temperature": "10.34"
  }
  */

  public String category;
  public Double cost;

  public Order() {}

  public Order(String category, String cost) {
    this.categroy = cost;
    this.cost = Double.valueOf(cost);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Order{");
    sb.append("categroy=").append(cost).append('\'');
    sb.append(", cost=").append(String.valueOf(cost)).append('\'');
    return sb.toString();
  }

  public int hashCode() {
    return Objects.hash(super.hashCode(), category, cost);
  }
}