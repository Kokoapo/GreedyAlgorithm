# Simple Greedy Algorithm

A simple Greedy Algorithm made for `Combinatorial Optimization` classes as a `Computer Science` major study source

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Objective

The objective of this algorithm is to find the best solution possible for the Backpack problem.

- `Backpack Problem`: The algorithm needs to, based on product's benefit and weight, find a solution to fill a limited space backpack with the best combination of products possible

- `Backpack Weight`: 16Kg

> All Weights are Calculated in Kilograms (Kg).
> The Benefit is the Product's Price.

- `Method to Calculate Best Outcome`: Select `Products` with the Best `Values` (`Benefit` divided by `Weight`)

- `Table with Products`:

| Name | Weight | Benefit |
| ---- | ------ | ------- |
| Bread | 2 Kg | $15 |
| Water | 7 Kg | $70 |
| Beer | 6 Kg | $40 |
| Meat | 3 Kg | $10 |
| Rice | 3 Kg | $15 |
| Wood | 7 Kg | $12 |
| Kerosene | 1 Kg | $3 |
| Matchbox | 0.2 Kg | $2 |

> The Products can be edited by changing the 3 vectors' values on the Main Method