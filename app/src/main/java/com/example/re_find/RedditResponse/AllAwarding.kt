package com.example.re_find.RedditResponse


import com.google.gson.annotations.SerializedName

data class AllAwarding(
    @SerializedName("award_sub_type")
    val awardSubType: String,
    @SerializedName("award_type")
    val awardType: String,
    @SerializedName("coin_price")
    val coinPrice: Int,
    @SerializedName("coin_reward")
    val coinReward: Int,
    val count: Int,
    @SerializedName("days_of_drip_extension")
    val daysOfDripExtension: Int,
    @SerializedName("days_of_premium")
    val daysOfPremium: Int,
    val description: String,
    @SerializedName("end_date")
    val endDate: Any,
    @SerializedName("icon_height")
    val iconHeight: Int,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("icon_width")
    val iconWidth: Int,
    val id: String,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    @SerializedName("resized_icons")
    val resizedIcons: List<ResizedIcon>,
    @SerializedName("start_date")
    val startDate: Any,
    @SerializedName("subreddit_coin_reward")
    val subredditCoinReward: Int,
    @SerializedName("subreddit_id")
    val subredditId: Any
)