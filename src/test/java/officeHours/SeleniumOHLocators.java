package officeHours;

public class SeleniumOHLocators {

    /*
    Locators :

    <button class="btn btn-primary" onclick="button1()">Button 1</button>

    <button -  </button>               ==> tags        -- purple/red
    class   -  onclick                 ==> attribute   -- orange
    "btn btn-primary"  - "button1()"   ==> value       -- blue/green
    Button 1                           ==> text        -- grey/black

    *** attribute = "value" ***
    Text is between 'opening' and 'closing' tag
    8 locators :

    1. id        (attribute)
    2. tagName   (tag)
    3. className (class) (attribute)
    4. name      (attribute)
    5. linkText         (text)
    6. partialLinkText  (text)
    7. XPath
    8. cssSelector

    LinkText {
        <a href="/autocomplete">Autocomplete</a>
        Tag -->  <a
         Attribute --> href
         Value --> "/autocomplete"
         Text -->  Autocomplete

         <a></a> --> This is the tag for link
         href --> url, endpoint for navigation
    for linkText we have to use the whole text --> "Autocomplete"
    }

    partialLinkText {
          <a href="/autocomplete">Autocomplete</a>
          we only need a portion of the text
          portion of text --> "Auto"

          <a href="/javascript_error">JavaScript onload event error</a>
          linkText --> "JavaScript onload event error"
          partialLinkText --> "onload"
          partialLinkText --> "JavaScript"
    }


    className VS name {

    <button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>

    Tag       --> <button </button>
    Attribute --> class, onclick, name
    value     --> "btn btn-primary" , "button2()" ,  "button2"

    className locator will find element with  -->  class attribute
    name locator will find element with   -->   name attribute

    }


    XPath {

    1. Absolute XPath (this is not recommended)
    begin with using single slash
    found the first button with absolute XPath
    /html/body/div/div[2]/div/div[1]/button[1]

    2. Relative XPath
    begins with double slash


    }

    Which one to choose first :
    1. id
    2. cssSelector
    3. XPath

        */



}
