//package officeHours;
//
//public class OH {
//    Locators
//​
//<button class="btn btn-primary" onclick="button1()" text ='button'>Button 1</button>
//<a href ='www.google.com'> </a>
//            (red) <button>  --> tags
//​
//        (Orange) class, onclick, value  --> attributes
//​
//        (Green) "btn btn-primary", "button1()" --> value
//​
//        (Grey) Button 1 ---> Text
//​
//    Example:
//<div id="page-footer" class="row">
//            ​
//    Tags --> <div>
//    Attributes --> id, class
//    Values --> "page-footer", "row"
//            ​
//            ****  attribute = "value" ****
//            ​
//    Most cases a locator will require to be unique.
//​
//    Text is between the 'opening' and 'closing' tag
//​
//        8 Locators:
//            1. id  (attribute)
// 2. tagName (tag)
// 3. className (class)(attribute)
//            4. name
// 5. linkText
// 6. partialLinkText
// 7. Xpath
// 8. cssSelector
//​
//    Which one to choose?
//            1. id
// 2. cssSelector
// 3. Xpath
//​
//        ​
//    LinkText {
//   <a href="www.google.com">Autocomplete</a>
//                Tag --> <a>
//                Attribute --> href
//        Value -->"/autocomplete"
//        Text --> Autocomplete
//​
//     <a></a> --> This is the tag for link
//        href --> url, endpoint for navigation
//​
//        For linkText we have to use the whole text --> "Autocomplete"
//
//    }
//​
//    partialLinkText {
//   <a href="www.google.com">Autocomplete</a>
//                We only need a portion of the text
//        Portion of text --> "Auto"
//​
//   <a href="/javascript_error">JavaScript onload event error</a>
//​
//        linkText --> "JavaScript onload event error"
//        partialLinkText --> "onload"
//        partialLinkText --> "JavaScript"
//        partialLinkText --> "event"
//    }
//​
//        ​
//    className  vs name {
//​
//   <button class="btn btn-primary" onclick="button2()"
//        name="button2">Button 2</button>
//                Tag --> button
//        Attributes --> class, onclick, name
//        Value --> "button2", "button2()", "btn btn-primary"
//​
//        className Locator will find element with --> class attribute
//           name locator will find the element with --> name attribute
//    }
//​
//        ​
//    Xpath {
//        1. Absolute Xpath (this is not recommend)
//        begin with single slash
//        /
//        Found the first button with absolute Xpath
//                /html/body/div/div[2]/div/div[1]/button[1]
//
//        2. Relative Xpath
//        begins with double slash
//        //
//        Start a designated tag
//        //tagName[@attribute='value']
//      <button class="btn btn-primary" onclick="button2()"
//        name="button2">Button 2</button>
//        //button[@name='button2']
//        //button[@class='btn btn-primary']
//        //button[@onclick='button2()']
//​
//        *Dynamic(changing) Elements*
//​
//        1. Any tag
//        tagName will be replaced with a *
//        //*[@attribute='value']
//
//        2. Operator 'and'
//        combine two different attributes to find a single Elements
//        First Way
//        //tagName[@attribute='value' and @attribute2 ='value2']
//        Second Way
//        //tagName[@attribute='value'][@attribute2='value2']
//           <button class="btn btn-primary" onclick="button2()"
//        name="button2_wuqyei">Button 2</button>
//​
//        //button[@class='btn btn-primary' and @onclick='button2()']
//        //button[@class='btn btn-primary'][@onclick='button2()']
//​
//​
//        3. Operator 'or'
//        //button[@class='btn btn-primary' or @onclick='button2()']
//​
//        4. Attribute 'starts-with'
//        //tagName[starts-with(@attribute,'value')]
//        value-> Could be partial value or beginning of a value
//            <button class="btn btn-primary"
//        onclick="button3()" id="button_b1">Button 3</button>
//        //button[starts-with(@id,'button_')]
//        //button(starts-with(text(),'Button'))
//
//​
//        5. Attribute 'ends-with'
//​
//        //tagName[ends-with(@attribute,'value')]
//        //button[ends-with(text(),'3')]
//​
//        6. Attribute 'contains'
//        //tagName[contains(@attribute,'value')]
//        //tagName[contains(text(),'TEXT')]
//​
//        7. Any attribute
//        attribute is replace with *
//        //tagName[@*='value']
//
//
//
//
//
//    }
