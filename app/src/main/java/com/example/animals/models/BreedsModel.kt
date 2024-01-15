package com.example.animals.models

class BreedResponse : ArrayList<BreedResponseItem>()

data class BreedResponseItem(
    var adaptability: Int,
    var affection_level: Int,
    var alt_names: String,
    var bidability: Int,
    var cat_friendly: Int,
    var cfa_url: String,
    var child_friendly: Int,
    var country_code: String,
    var country_codes: String,
    var description: String,
    var dog_friendly: Int,
    var energy_level: Int,
    var experimental: Int,
    var grooming: Int,
    var hairless: Int,
    var health_issues: Int,
    var hypoallergenic: Int,
    var id: String,
    var indoor: Int,
    var intelligence: Int,
    var lap: Int,
    var life_span: String,
    var name: String,
    var natural: Int,
    var origin: String,
    var rare: Int,
    var reference_image_id: String,
    var rex: Int,
    var shedding_level: Int,
    var short_legs: Int,
    var social_needs: Int,
    var stranger_friendly: Int,
    var suppressed_tail: Int,
    var temperament: String,
    var vcahospitals_url: String,
    var vetstreet_url: String,
    var vocalisation: Int,
    var weight: Weight,
    var wikipedia_url: String
)

data class Weight(
    var imperial: String,
    var metric: String
)