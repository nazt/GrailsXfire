class BookService {
  static expose=['xfire']
 boolean transactional = true
  Book[] getBooks(){
    Book.list() as Book[]
  }
  Integer countBooks()
	{
		Book.list().size()
	}
  Book[] findBooksByName(String s) {
        def c = Book.createCriteria()
        def results = c{
            like("name", "%${s}%")
        }
		 results as Book[]
	}
    static conversions = [
      'AUD': [ 'USD': 100.00D, 'GBP': 44.44D ],
      'USD': [ 'AUD': 1.00D, 'GBP': 88.88D ],
      'GBP': [ 'AUD': 22.22D, 'USD': 33.33D ]
    ]

    Double convert(String from, String to, Double amount) {
        conversions[from][to] * amount
    }	
}
