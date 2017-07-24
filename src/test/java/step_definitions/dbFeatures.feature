Feature: Check computer db behaviour

  Scenario Outline: Check creation scenario:

    Given I open db page in "<Browser>"

    When Press to the Add a new computer button
    And Filled the data fields with the values:
      | computerName | <Computer name for Create>     |
      | IntroDate    | <Introduced date for Create>   |
      | DiscDate     | <Discontinued date for Create> |
      | CompName     | <Company name for Create>      |

    And Press Create Computer button

    And I type  computer name in Filter by computer name field
      | <Computer name for Create> |

    And I press Filter By Name button


    And Press on computer name in appeared row
      | <Computer name for Create> |

    Then in open window I have to be able to see values:
      | computerName | <Computer name for Create>     |
      | IntroDate    | <Introduced date for Create>   |
      | DiscDate     | <Discontinued date for Create> |
      | CompName     | <Company name for Create>      |

    Examples:
      | Browser | Computer name for Create | Introduced date for Create | Discontinued date for Create | Company name for Create |
      | FireFox | 1!                       | 1980-02-28                 | 2077-02-28                   | IBM                     |
      | Chrome  | Computer_Name_1111111    | 1980-02-28                 | 2077-02-28                   | IBM                     |
      | Chrome  | Computer_Name_1111112    | 2017-02-28                 | 2017-07-28                   | IBM                     |


  Scenario Outline: Check update scenario:

    Given I open db page in "<Browser>"

    When  I type  computer name in Filter by computer name field
      | <Computer name for Create> |

    And I press Filter By Name button

    And   Press on computer name in appeared row
      | <Computer name for Create> |


    And Filled the data fields with the values:
      | computerName | <Computer name for Update>     |
      | IntroDate    | <Introduced date for Update>   |
      | DiscDate     | <Discontinued date for Update> |
      | CompName     | <Company name for Update>      |


    And Press Save this computer button

    And I type  computer name in Filter by computer name field
      | <Computer name for Update> |

    And I press Filter By Name button



    And Press on computer name in appeared row
      | <Computer name for Update> |


    Then in open window I have to be able to see values:
      | computerName | <Computer name for Update>     |
      | IntroDate    | <Introduced date for Update>   |
      | DiscDate     | <Discontinued date for Update> |
      | CompName     | <Company name for Update>      |


    Examples:
      | Browser | Computer name for Create | Computer name for Update | Introduced date for Update | Discontinued date for Update | Company name for Update |
      | FireFox | 1!                       | 1! 1!                    | 1980-03-28                 | 2077-01-28                   | Sony                    |
      | Chrome  | Computer_Name_1111111    | Computer_Name_1111122    | 1980-03-28                 | 2077-01-28                   | Sony                    |
      | Chrome  | Computer_Name_1111112    | Computer_Name_1111___    | 2017-03-28                 | 2017-01-28                   | Sony                    |


  Scenario Outline: Check delete scenario:
    Given I open db page in "<Browser>"
    When  I type  computer name in Filter by computer name field
      | <Computer name for Update> |
    And I press Filter By Name button

    And   Press on computer name in appeared row
      | <Computer name for Update> |

    And Press Delete This Computer button

    And I type  computer name in Filter by computer name field
      | <Computer name for Update> |
    And I press Filter By Name button

    Then There is should not be row with deleted computer
      | <Computer name for Update> |


    Examples:
      | Browser | Computer name for Update |
      | FireFox | 1! 1!                    |
      | Chrome  | Computer_Name_1111122    |
      | Chrome  | Computer_Name_1111___    |


