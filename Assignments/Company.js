// Define the array of orders
const orders = [
  { name: 'Order 1', description: 'Description 1', date: '2022-01-01', status: 'Pending' },
  { name: 'Order 2', description: 'Description 2', date: '2022-01-02', status: 'Completed' },
  { name: 'Order 3', description: 'Description 3', date: '2022-01-03', status: 'Shipped' }
];

// Use map to construct an array of JSON objects
const jsonOrders = orders.map(order => ({
  name: order.name,
  description: order.description,
  date: order.date,
  status: order.status
}));

// Print the JSON array
console.log(jsonOrders);

// Output in Chrome Developer Tools:
// 1. creates a new array with the results of calling a function on every element in the calling array.
// 2. written as key/ value pairs using Json object.
// 3. JSON object says “orders” with lot of keys like name, description, date, status.
// 4. Convert Json file into the JavaScript file.
// 5. Get the final output of this program.
