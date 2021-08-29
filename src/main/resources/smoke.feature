Feature: Smoke
  As a user
  I want to test some of site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Let's verify that the word "рыба" correctly appears in the first paragraph ("Что такое Lorem Ipsum?")
    Given User opens '<homePage>' page
    And User checks languages panel visibility
    When User switch to Russian language
    Then User verifies that the first paragraph, contains the word '<word>'

    Examples:
      | homePage                            | word                       |
      |          https://lipsum.com/        | рыба                       |



  Scenario Outline: Let's verify that checkbox setting result in text starting with Lorem ipsum or not
    Given User opens '<homePage>' page
    And User clicks on checkbox if '<click condition>'
    And User clicks “Generate Lorem Ipsum” button
    Then User checks that text starts with "Lorem ipsum dolor sit amet, consectetur adipiscing elit" is '<starts with condition>'

    Examples:
      | homePage             |   starts with condition                      | click condition  |
      | https://lipsum.com/  |   true                                       | false            |
      | https://lipsum.com/  |   false                                      | true             |



  Scenario Outline: Let's verify that Lorem Ipsum is generated with correct size for different types of button
    Given User opens '<homePage>' page
    And User clicks '<button type>'
    Then User inputs into the number field '<number input>'
    And User clicks “Generate Lorem Ipsum” button
    Then User verifies that result has '<number result>' words

    Examples:
      | homePage                         |   number input       | number result | button type |
      |          https://lipsum.com/     |  10                  | 10            | words       |
      |          https://lipsum.com/     |  -1                  | 1             | bytes       |
      |          https://lipsum.com/     |  0                   | 5             | words       |
      |          https://lipsum.com/     |  5                   | 1             | bytes       |
      |          https://lipsum.com/     |  20                  | 20            | words       |

  Scenario Outline: Check that randomly generated text paragraphs contain the word "lorem" with probability
    of more than 20%:
    Given User opens '<homePage>' page
    And User clicks “Generate Lorem Ipsum” button
    Then User verifies that probability of '<word>' is more than '<percent>'

    Examples:
      | homePage                            | word                       | percent |
      |          https://lipsum.com/        | lorem                      | 20      |

