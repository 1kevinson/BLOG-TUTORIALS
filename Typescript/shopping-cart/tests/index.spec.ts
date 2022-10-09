import Shopping from "../src/index";

let shopping: Shopping;

beforeEach(()=> {
  shopping = new Shopping();
})

describe("Shopping cart total", () => {
  it("return 0 when the cart is empty", () => {
    const total = shopping.totalize([]);
    expect(total).toBe(0.0);
  });

  it("return unit price when it's a single item in the cart", () => {
    const total = shopping.totalize([{ unitPrice: 15.0, quantity: 1, discount: 0 }]);
    expect(total).toBe(15.0);
  });

  it("return total price when it's a single item in the cart", () => {
    const shoppingCart: Cart[] = [
      { unitPrice: 12.0, quantity: 2, discount: 0 },
      { unitPrice: 30.0, quantity: 4, discount: 5.5 },
      { unitPrice: 20.0, quantity: 1, discount: 4 }
    ];
    const total = shopping.totalize(shoppingCart);
    expect(total).toBe(154.5);
  });

  it("return an error when quantity is O and an item exist in the cart", () => {
    expect(()=> {
      shopping.totalize([{ unitPrice: 10.0, quantity: 0, discount: 0 }]);
    }).toThrowError(new Error('Quantity 0 is not allowed when it\'s an item in cart'));
  });

  it("return an error when quantity is O and many items exist in the cart", () => {
    const shoppingCart: Cart[] = [
      { unitPrice: 10.0, quantity: 0, discount: 0 },
      { unitPrice: 30.0, quantity: 4, discount: 6 }
    ];
    expect(()=> {
      shopping.totalize(shoppingCart);
    }).toThrowError(new Error('Quantity 0 is not allowed when it\'s an item in cart'));
  });
});

/* Test list 
- the total should be 0 when the basket is empty
- the total should be a unit price when it's a single item in basket
- the total should be unit price * quantity * discount of single item
- the total should be total of price * quantity * discount of many items
- Exceptional case: the quantity is O (quantity 0 doesn't makes sense in a shopping cart)
- Exceptional case: the discount is null
*/
