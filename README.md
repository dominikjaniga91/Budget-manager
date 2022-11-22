# Overview
This is an budget manager app created on JetBrains Academy. The process of creating app consist of 5 stages. Go directly to Stage 5 (not implemented yet) to see the final result. Every stage has a despription an examples.

# Stage 1
## Description
First, let’s implement the counting of your purchases. It’s much easier to analyze when your expenses are presented as a list. Read data from the console and at the end show the list of all purchases and its total amount.
It should be displayed as follows: Total: $23.00

Your program should process every line the user inputs. To end the input, the user should type End-of-file symbol that tells your operating system that no more input will be provided. It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows. Don't be scared: you don’t have to implement it yourself, this is a special built-in hot-key that gives the command to stop input. See for yourself!

### Example
The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

```
> Almond 250gm $35.43
> LEGO DUPLO Town Farm Animals $10.10
> Sensodyne Pronamel Toothpaste $19.74
> Hershey's milk chocolate bars $8.54
> Gildan LT $8.61
Almond 250gm $35.43
LEGO DUPLO Town Farm Animals $10.10
Sensodyne Pronamel Toothpaste $19.74
Hershey's milk chocolate bars $8.54
Gildan LT $8.61

Total: $82.42
```

# Stage 2
## Description
Let's make your application more convenient. Only counting the expenses is a little bit sad, right?

To make your application flexible and functional, add a menu that consists of 4 items.

Add Income. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
Add Purchase. This item should add a purchase to the list. You have implemented this feature in the previous stage.
Show the list of purchases. This menu item should display a list of all expenses and incomes in the order they were made.
Balance. Show the balance.
Exit. Exit the program. Make this item under number 0, not number 5.
Notice, that the amount of remaining money cannot be negative. In this case, make the balance equal to $0.

When displaying the price or the total amount, print 2 numbers after the point.
Example: $14.20
Follow this rule in the next stages.

### Example
The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 1

Enter income:
> 1000
Income was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 4

Balance: $1000.00

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

The purchase list is empty

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 2

Enter purchase name:
>Red Fuji Apple
Enter its price:
> 5.99
Purchase was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

Red Fuji Apple $5.99
Total sum: $5.99

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 0

Bye!
```

# Stage 3
## Description
To better control the expens, we need to categorize our purchases. It helps to see how exactly your budget is distributed: you may be actually quite surprised!

Implement a function that assigns a purchase to a specific category.

The program should have the following categories:
**Food**
**Clothes**
**Entertainment**
**Other**

The function allows you to output the shopping list by type. After selecting the action of showing the list of expens, offer to show either a certain category or a general list. At the end print the total amount of purchases that are on the list.

### Example
The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

The purchase list is empty!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 2

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 1

Enter purchase name:
> Milk
Enter its price:
> 3.5
Purchase was added!

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 5

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 4

Other:
The purchase list is empty!

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 1

Food:
Milk $3.50
Total sum: $3.50

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 5

All:
Milk $3.50
Total sum: $3.50

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 6

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 0

Bye!
```
# Stage 4
## Description
What's the point of counting the money if the results are lost and forgotten once you close the program? To allow for some long-term budget planning, we need to save purchases to file. Add items Save and Load to the menu.

Save should save all purchases to the file.
Load should load all purchases from the file.

Use the purchases.txt file to store purchases.

### Examples
The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

#### Example 1:

```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 1

Enter income:
> 1000
Income was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 2

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 1

Enter purchase name:
> Almond 250g
Enter its price:
> 35.43
Purchase was added!

Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
> 5

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 5

Purchases were saved!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 0

Bye!
```
#### Example 2:

```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 6

Purchases were loaded!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 3

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 1

Food:
Almond 250g $35.43
Total sum: $35.43

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 5

All:
Almond 250g $35.43
Total sum: $35.43

Choose the type of purchases
1) Food
2) Clothes
3) Entertainment
4) Other
5) All
6) Back
> 6

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 4

Balance: $964.57

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
0) Exit
> 0

Bye!
```