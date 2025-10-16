# UML Class Diagram

Here is a UML class diagram, specified using [Mermaid][mer].

```mermaid
classDiagram
  Customer -- Order: places
  Order -- OrderItem: includes
  class Customer {
    name: String
    address: String
    placeOrder()
  }
  class Order {
    orderNumber: Int
    datePlaced: Date
    deliveryDate: Date
    checkStock()
    takePayment()
  }
  class OrderItem {
    name: String
    description: String
  }
```


[mer]: https://mermaid.js.org/
