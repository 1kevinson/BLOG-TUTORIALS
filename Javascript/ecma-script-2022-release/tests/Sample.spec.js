import Sample from "../src/Sample";

describe("Sum of 2 numbers", () => {
  it("should return 11 for 5 + 6", () => {
    const demo = new Sample();
    expect(demo.sum(5, 6)).toBe(11);
  });
});