const sortArray = require("./helpers")

describe("Testing binary search code", () => {
  test("default test case", () => {
    const array = [2, 1, 4, 10, 15, 62, 6, 7, 9]

    const newArray = sortArray(array)
    expect(newArray).toEqual([1, 2, 4, 6, 7, 9, 10, 15, 62])
  })
})