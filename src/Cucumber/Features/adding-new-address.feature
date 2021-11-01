Feature: User new address

  Scenario: Dodawanie adresu

    Given użytkownik "<nazwa użytkownika>" zalogowany haslem "<hasło użytkownika>"
    And uzytkownik wpisuje "<alias>", "<adres>", "<kod pocztowy>", "<miasto>", "<państwo>", "<phone>"
    When formularz wypelniony
    Then adres dodany

    Examples:
    |nazwa użytkownika         |hasło użytkownika|alias         |adres      |kod pocztowy|miasto|państwo       |phone    |
    |anna.echelon6277@gmail.com|536294637        |My New Address|Koszykowa 1|32-645      |London|United Kingdom|654234178|
    |irlandka139@interia.eu    |Stereo           |Address UK    |Rainbow 74 |64-867      |Leeds |United Kingdom|765893098|

