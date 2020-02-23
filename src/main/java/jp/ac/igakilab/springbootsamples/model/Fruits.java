package jp.ac.igakilab.springbootsamples.model;

/**
 * フルーツの発注リスト
 */
public class Fruits {
  private int id;
  private String name;// 果物の名前
  private int num;// 数
  private double weight;// 平均重量
  private String details;// 詳細
  private boolean sent;// 発送済みかどうか

  public int getId() {
    return id;
  }

  public boolean isSent() {
    return sent;
  }

  public void setSent(boolean sent) {
    this.sent = sent;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

}
