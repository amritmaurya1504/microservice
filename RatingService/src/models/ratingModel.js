const mongoose = require("mongoose");

const ratingSchema = new mongoose.Schema({
    userId : {
        type : String,
        required : true
    },
    hotelId: {
        type: String,
        required: true
    },
    rating: {
        type: Number,
        required: true,
        min: 1, // Assuming rating is between 1 and 5
        max: 5
    },
    feedback: {
        type: String,
        required: true
    }
})

const Rating = mongoose.model('Rating', ratingSchema);

module.exports = Rating;