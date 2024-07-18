const Rating = require("../models/ratingModel")

exports.createRating = async (req, res) => {
    try {
        const rating = new Rating(req.body);
        await rating.save();
        res.status(201).json(rating);
    } catch (err) {
        res.status(400).json({ error: err.message });
    }
};

exports.getSingleRating = async (req, res) => {
    try {
        const rating = await Rating.findById(req.params.ratingId);
        if (!rating) {
            return res.status(404).json({ error: 'Rating not found' });
        }
        res.json(rating);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// Get all reviews
exports.getAllRatings = async (req, res) => {
    try {
        const ratings = await Rating.find();
        res.json(ratings);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// Get all ratings by userId
exports.getRatingsByUserId = async (req, res) => {
    try {
        const ratings = await Rating.find({ userId: req.params.userId });
        res.json(ratings);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

// Get all ratings by hotelId
exports.getRatingsByHotelId = async (req, res) => {
    try {
        const ratings = await Rating.find({ hotelId: req.params.hotelId });
        res.json(ratings);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};