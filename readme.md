# Book API

This is a book api built on [top of this kaggle dataset](https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks?resource=download)

Built to learn java and spring boot

## Endpoints
all endpoints are get endpoints and will return a json response similar to the following
```json
{
  "count": 20,
  "results": []
}
```
count = the number of results in `results`

results = An array of book models

```json
// Book model
{
  "bookID" : 0,
  "title" : "",
  "authors" : "",
  "average rating" : 0.0,
  "isbn": "",
  "isbn13": "",
  "language" : "eng",
  "num_pages" : 0,
  "publication_date" : "",
  "publisher" : ""
}
```