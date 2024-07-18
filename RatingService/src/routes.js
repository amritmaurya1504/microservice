const express = require("express");
const { createRating, getAllRatings, getSingleRating, getRatingsByUserId, getRatingsByHotelId } = require("./controllers/ratingController");
const route = express.Router();


route.route("/").post(createRating);
route.route("/").get(getAllRatings);
route.route("/:ratingId").get(getSingleRating);
route.route("/user/:userId").get(getRatingsByUserId);
route.route("/hotel/:hotelId").get(getRatingsByHotelId);

module.exports = route;