function sortArray(array) {
  // ... is known as the spread syntax to copy an array. Not copying the array when sorting will mutate the original array, which we don't want because it can cause unintended side effects
  return [...array].sort((a, b) => a-b);
}

module.exports = sortArray