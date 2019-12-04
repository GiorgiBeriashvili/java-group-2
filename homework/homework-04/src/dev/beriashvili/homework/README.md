# Text Generator

The program serves as a text generator. Please read the instructions below.

---

## Description

An example of valid parameters - `p-d-d-s-d-d-w-d-d-c-d-d`

- `p` = paragraph range
- `s` = sentence range
- `w` = word range
- `c` = character range
- `d` = decimal, - the minimum and the maximum range is based on these values

The default parameters: `p-1-10-s-1-10-w-1-10-c-1-10`

Valid parameters are determined after being pattern matched via the following regular expressions:

- First layer: `^\D*\d+\D+\d+\D+\d+\D+\d+\D+\d+\D+\d+\D+\d+\D+\d+\D*$`
- Second layer: `^\D*\d+\D+\d+\D+\d+\D+\d+\D*$`
- Third layer: `^\D*\d+\D+\d+\D*$`
- Fourth layer: `^\D*\d+\D*$`

To summarize, - only the quantity of the provided numeric values are taken into the account.

Thus, per available pattern matchers, provide either: `8`, `4`, `2` or `1` separate numeric values in any form you desire.

If pattern matchers fail to identify valid parameters, - the default parameters are parsed instead.

---

## Usage

Let us see how different provided parameters are matched according to the aforementioned rules:

1. Parameters: `1 6 2 4 4 6 2 5`

    First layer's regular expression's pattern will match these parameters, resulting in the following parsed parameters: `[1, 6, 2, 4, 4, 6, 2, 5]`

    Notice how it was not necessary to write the parameters in the following format due to the first layer's regular expression: `p-d-d-s-d-d-w-d-d-c-d-d`

2. Parameters: `4 6 2 3`

    Second layer's regular expression's pattern will match these parameters, resulting in the following parsed parameters: `[1, 4, 1, 6, 1, 2, 1, 3]`

    Notice how the minimum bound is fixed to be the numeric value of `1`.

3. Parameters: `10 2`

    Third layer's regular expression's pattern will match these parameters, resulting in the following parsed parameters: `[2, 10, 2, 10, 2, 10, 2, 10]`

    Notice how it switched the order of the parameters, due to the minimum bound being numerically greater than the maximum bound.

4. Parameters: `5`

    Fourth layer's regular expression's pattern will match these parameters, resulting in the following parsed parameters: `[1, 5, 1, 5, 1, 5, 1, 5]`

5. Parameters: `please generate text for me, thank you`

    All of the layers' regular expressions's patterns will fail to match this input, thus the default parameters `p-1-10-s-1-10-w-1-10-c-1-10` will be pattern matched by the first layer instead.

    First layer's regular expression's successful pattern matching for the default parameters results in the following parsed parameters: `[1, 10, 1, 10, 1, 10, 1, 10]`
