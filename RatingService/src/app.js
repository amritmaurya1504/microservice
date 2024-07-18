require("dotenv").config();
const express = require('express');
const app = express();
const PORT = process.env.PORT || 8083;
const connectDB = require("./config/db")

// Import and initialize the Eureka client
const eurekaClient = require('./eureka-client');

// Middleware to parse JSON bodies
app.use(express.json());
connectDB();

// Basic route
app.get('/', (req, res) => {
    res.send('Hello, This is Rating Service!');
});

const ratingRoutes = require("./routes.js")
app.use("/ratings", ratingRoutes);

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});

process.on('SIGINT', () => {
    eurekaClient.stop();
    process.exit();
  });