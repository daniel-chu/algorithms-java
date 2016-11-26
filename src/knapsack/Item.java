package knapsack;

/**
 * Class representing an item.
 */
public class Item {

  /**
   * Name of item.
   */
  String name;

  /**
   * Weight of the item.
   */
  private int weight;

  /**
   * How much this item is worth.
   */
  private int price;

  /**
   * Constructor for an Item.
   *
   * @param weight weight of item
   * @param price  price of item
   */
  public Item(String name, int weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  /**
   * Gets the weight of this item.
   *
   * @return weight of this item
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * Gets the price of this item.
   *
   * @return price of this item
   */
  public int getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return "Item Name: " + this.name + "| Weight: " + this.weight + "| Price: " + this.price;
  }

}
