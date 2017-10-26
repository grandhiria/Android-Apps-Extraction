curl -XPOST "https://42matters.com/api/1/apps/query.json?access_token=2dbe0b639a91db121baf6e53ccb431db4d4d7783&fields" -d '


{
  "query": {
    "name": "Most Popular Apps",
    "platform": "android",
    "query_params": {
      "sort": "score",
      "from": 0,
      "num": 100,
      "i18n_lang": [],
      "cat_int": [
        "9",
        "10",
        "12",
        "6",
        "15"
      ],
      "content_rating": [],
      "sort_order": "desc",
      "downloads_lte": "",
      "downloads_gte": "",
      "full_text_term": "dummy-test-12x",
      "include_full_text_desc": true,
      "title_contains_term": false,
      "include_developer": true
    }
  }
}'

