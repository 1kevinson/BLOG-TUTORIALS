export default class Shopping {

  public totalize(cart: Cart[]): number {
    if (this.isEmptyCart(cart)) { return 0; }

    if (this.isSingleItem(cart)) { 
        this.checkQuantityNumber(cart, 0);
        return this.totalOfSingleItem(cart, 0); 
    }

    const total: number[] = [];
    for (let itemIndex = 0; itemIndex < cart.length; itemIndex++) {
        this.checkQuantityNumber(cart, itemIndex);
        total.push(this.totalOfSingleItem(cart,itemIndex));
    }

    return total.reduce((prev, next) => prev + next, 0);
  }

  private checkQuantityNumber(cart: Cart[], index:number): void {
    if (this.isQuantityNumberNotValid(cart, index)) { throw new Error('Quantity 0 is not allowed when it\'s an item in cart'); }
  }

  private isQuantityNumberNotValid(cart: Cart[], index: number): boolean { return cart[index].quantity === 0; }

  private totalOfSingleItem(cart: Cart[], itemIndex: number): number {
    return cart[itemIndex].unitPrice * cart[itemIndex].quantity - cart[itemIndex].discount;
  }

  private isSingleItem(cart: Cart[]): boolean { return cart.length === 1; }

  private isEmptyCart(cart: Cart[]): boolean { return cart.length === 0; }

}
