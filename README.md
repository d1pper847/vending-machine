# 🥤 Smart Vending Machine Simulator

A lightweight, console-based vending machine engine built in Java. This project simulates a hardware-software interface by tracking physical inventory levels, validating transactional cash deposits, and calculating optimal coin payouts.

---

## 🚀 Key Architectural Features

* **Live Inventory Tracking:** Parallel data arrays seamlessly monitor current stock capacities and dynamically adjust text indicators to `OUT OF STOCK` when quantities hit zero.
* **Input and Boundary Safeguards:** Complete type-safety checks handle invalid selections or non-numeric cash inputs without crashing the machine runtime.
* **The Greedy Change-Maker Algorithm:** Rather than spitting out messy change combinations, the mathematical engine converts balances into total cents to bypass floating-point rounding errors and outputs change using the **absolute fewest coins possible** (Quarters, Dimes, Nickels, Pennies).

---

## 🛠️ Installation & Execution

### Prerequisites
Ensure you have the **Java Development Kit (JDK)** installed on your machine:
```bash
java -version
