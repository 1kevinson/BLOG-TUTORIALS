export default class Shopping {
    totalize(cart) {
        if (this.isEmptyCart(cart)) {
            return 0;
        }
        if (this.isSingleItem(cart)) {
            this.checkQuantityNumber(cart, 0);
            return this.totalOfSingleItem(cart, 0);
        }
        const total = [];
        for (let itemIndex = 0; itemIndex < cart.length; itemIndex++) {
            this.checkQuantityNumber(cart, itemIndex);
            total.push(this.totalOfSingleItem(cart, itemIndex));
        }
        return total.reduce((prev, next) => prev + next, 0);
    }
    checkQuantityNumber(cart, index) {
        if (this.isQuantityNumberNotValid(cart, index)) {
            throw new Error('Quantity 0 is not allowed when it\'s an item in cart');
        }
    }
    isQuantityNumberNotValid(cart, index) { return cart[index].quantity === 0; }
    totalOfSingleItem(cart, itemIndex) {
        return cart[itemIndex].unitPrice * cart[itemIndex].quantity - cart[itemIndex].discount;
    }
    isSingleItem(cart) { return cart.length === 1; }
    isEmptyCart(cart) { return cart.length === 0; }
}
//# sourceMappingURL=index.js.map