# Chocolate Factory System

> A Java console app that manages a chocolate factory's products and customer orders. Products are kept in a binary search tree keyed by price.

## Overview

The Chocolate Factory System is a data-structures project. It stores every product (name, price, quantity) in a **Binary Search Tree (BST)** ordered by price. Customer orders are stored as **linked lists of bill items**. A menu-driven console interface lets staff add products, browse them in price order, search by price, take orders that reduce stock, restock products, and review past orders with their totals.

## Features

| # | Menu option | What it does |
|---|---|---|
| 1 | Insert new product | Adds a product (name, price, quantity) to the BST |
| 2 | View all products sorted by price | In-order BST traversal |
| 3 | Search for products based on price | BST search by price |
| 4 | Ask for order | Pick products and quantities. Stock is reduced, and the bill total is calculated |
| 5 | Add quantity to a product | Restock an existing product |
| 6 | View all orders | Prints every stored order with its items and total |
| 7 | Exit | – |

- Input validation for menu choices and product numbers
- Up to 10 orders are stored per session (fixed-size `Orders[]` array)

## Data Structures

- `BST` / `BSTNode`: binary search tree of `Product`, keyed by price (insert, search, in-order listing)
- `Orders` / `BillNode`: singly linked list of the items in one order, with `CalculateTotal()`
- `Product`: name, price and quantity

## Tech Stack

- **Java** (console, `java.util.Scanner`)
- NetBeans Ant project (`build.xml`, `nbproject/`)

## How to Run

**NetBeans:** open the folder as a project and run it. The main class is `chocolatefactorysystem.Main`.

**Command line (JDK 8+):**
```bash
javac -d out src/chocolatefactorysystem/*.java
java -cp out chocolatefactorysystem.Main
```

## Example

```
1- Insert new product
2- View all products sorted by price
...
2
Products is as follow:
	Product: name: Milk Bar, price: 5.0, quantity: 100
	Product: name: Hazelnut Praline, price: 8.75, quantity: 60
	Product: name: Dark Truffle, price: 12.5, quantity: 40
```

## Project Structure

```
chocolate-factory-system/
├── src/chocolatefactorysystem/
│   ├── Main.java       # menu + program flow
│   ├── BST.java        # binary search tree of products
│   ├── BSTNode.java
│   ├── Product.java
│   ├── Orders.java     # linked list of bill items
│   └── BillNode.java
├── nbproject/
├── build.xml
└── manifest.mf
```

## Credits

Team university project at Umm Al-Qura University. **Hala Jalal** contributed as a team member (teammate names were not recorded in the available materials).

## License

[MIT](LICENSE) © 2025 Hala Jalal
