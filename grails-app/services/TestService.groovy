class TestService {

    boolean transactional = false

    static expose=['xfire']

    static conversions = [
      'AUD': [ 'USD': 100.00D, 'GBP': 44.44D ],
      'USD': [ 'AUD': 1.00D, 'GBP': 88.88D ],
      'GBP': [ 'AUD': 22.22D, 'USD': 33.33D ]
    ]

    Double convert(String from, String to, Double amount) {
        conversions[from][to] * amount
    }
}