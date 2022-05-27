Feature: Smoke
  As a user
  I want to test site functionality


  Scenario Outline: Check the name of headline article
    Given User opens '<homePage>' page
    When User clicks 'News' menu
    Then User checks the name of the headline article contains '<articleName>'

    Examples:
      | homePage             | articleName                                         |
      | https://www.bbc.com/ | Police admit Texas shooting response was wrong |

  Scenario: Check the name of secondary articles
    Given User opens 'https://www.bbc.com/' page
    When User clicks 'News' menu
    Then User checks the name of the secondary articles contains list of article`s titles
      |Husband of killed Texas teacher 'dies of grief'      |
      |Monkeypox patients should avoid pet contact          |
      |Pet Shop Boys pay tribute to Depeche Mode's Fletcher |

  Scenario Outline: Check that articles on search page have the keyword
    Given User opens '<homePage>' page
    When User clicks 'News' menu
    And User copy the Category link of the headline article
    And User click on Search bar
    And User enter Category link to the Search bar
    Then User checks the name of the first article contains Category link

    Examples:
      | homePage             |
      | https://www.bbc.com/ |


  Scenario Outline: Check that form don`t submit witout checked Terms
    Given User opens '<homePage>' page
    And User clicks 'News' menu
    When User click on 'Coronavirus' tab
    And User click on Contact BBC News link
    And User click on 'send us a story' link
    And User fill the submit form with '<userName>' and '<email>' and '<story>'
    Then User checks the error message '<message>' present

    Examples:
      | homePage             |userName|email          |story  |message|
      | https://www.bbc.com/ |Alex    |mail@mymail.com|Hello  |must be accepted|


  Scenario Outline: Check that form don`t submit witout required fields
    Given User opens '<homePage>' page
    And User clicks 'News' menu
    When User click on 'Coronavirus' tab
    And User click on Contact BBC News link
    And User click on 'send us a story' link
    And User check accept the terms checkbox
    And User fill the submit form with '<userName>' and '<email>' and '<story>'
    Then User checks the error message '<message>' present

    Examples:
      | homePage             |userName|email          |story|message|
      | https://www.bbc.com/ |Alex    |mail@mymail.com|     |can\'t be blank|
      | https://www.bbc.com/ |        |mail@mymail.com|Hello|Name can\'t be blank|


  Scenario Outline: Check that team scores display correctly for 2022 year
    Given User opens '<homePage>' page
    And User clicks 'Sport' menu tab
    And User click on 'Football' tab
    And User click on 'Scores and Fixtures' link
    When User enter '<competition>' in input field
    And User choose the '<month>'
    Then User check that '<team1>' and '<team2>' played with the score '<score1>':'<score2>'
    And User click on 'team1' name
    And User check that on match page '<team1>' and '<team2>' played with the score '<score1>':'<score2>'

    Examples:
      | homePage             |month|competition           |team1             |team2           |score1 |score2|
      | https://www.bbc.com/ |APR  |Scottish Championship |Arbroath          |Greenock Morton |3      |0     |
      | https://www.bbc.com/ |FEB  |Scottish Championship |Dunfermline       |Kilmarnock      |0      |0     |
      | https://www.bbc.com/ |APR  |German Bundesliga     |Borussia Dortmund |VfL Bochum 1848 |3      |4     |
      | https://www.bbc.com/ |MAR  |French Coupe de France|Nantes            |Monaco          |2      |2     |
      | https://www.bbc.com/ |APR  |Italian Coppa Italia  |Juventus          |Fiorentina      |2      |0     |