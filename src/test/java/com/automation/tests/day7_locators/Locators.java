package com.automation.tests.day7_locators;

public class Locators {

    /**
     * id
     * name
     * tagName
     * className
     * linkedText
     * partialLinkedText
     * XPath
     * cssSelector
     *
     * In selenium script we create web element for every html element on the page
     * We use tags and attributes to come up with locator
     *
     * #1 id - if it's consistent, then use it
     *
     * <div id="smth"></div>
     *
     * #2 name  - almost every time unique
     *
     * <div name="smth"></div>
     *
     * #3 className - almost never unique
     *
     * <div class="smth"></div>
     *
     * #4 tagName  - almost never unique, except <h1 tag
     *
     * <h1>This is page heading</h1>
     *
     * #5 linkText  - always about a element
     *
     * <a href="http://google.com">Link text</a>
     *
     * #6 partialLinkText
     *
     * <a href="http://google.com">Link text</a>
     * When you use it, you can mention only part of the link, not complete or exact
     *
     * #7 XPath  - xml path
     *
     * xml - it's document that looks like HTML, also based on tags
     * there are 2 types of XPath : absolute and relative
     * absolute, usually not used in test automation, for finding locators
     * In rear cases when it is useful :
     *      ==> when you expect some element in the specific place
     *      absolute depends on nodes
     *      you need to start from the root element
     *      In HTML it's a => <html>
     *      absolute XPath always starts with =>  forward slash  /
     *
     *      /html/body/div[2]/bitton
     *      you have to go from parent -   to child
     *      html
     *          head
     *          body
     *              div
     *              div
     *                  button
     *
     *      node - it's like one element , it refers to any html element
     *
     *      Instead, we mostly use relative XPath.
     *      It starts with 2 forward slashes //
     *      It can start from any element => not only from root element
     *
     *      //tagName[@attribute='value']
     *      //tagName[@attribute="value"]
     *      //tagName[text()="text of element"]
     *
     * for ex:
     *
     *  <button onclick="button1()">Button 1</button>
     *   //button[@onclick="button1()"]
     *   //button[text()="button1()"]
     *
     *   text is always in between > <
     *
     *   //button[.='Button 1']
     *   . - means any element
     *
     *   //button[contains(text(), '1')]
     *
     *   //button[contains(@onclick, 'button 1')]
     *
     *   ### how to go from child-to-parent element ###
     *   /..
     *
     *   for example;
     *
     *
     *   advantages of XPath over cssSelector
     *   navigation to both directions
     *   ability to find element by text
     *
     *child to parent :
     * child xpath/parent::tagName
     * child to child :
     * child xpath/following-siblinn::tagName[index]
     *
     */
}
