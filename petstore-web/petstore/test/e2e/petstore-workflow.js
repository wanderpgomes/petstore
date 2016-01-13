describe('Petstore', function() {

  var petName = 'Pet-'+ Date.now();

  beforeEach(function() {
    browser.get('http://localhost:9000/#/');
  });

  it('should add a pet', function() {
    
    element(by.model('name')).sendKeys(petName);
    element(by.model('status')).sendKeys('Sold');
    element(by.id('add')).click();

    var petList = element.all(by.repeater('pet in pets'));

    expect(petList.last().getText()).toContain(petName);
    
  });

  it('should select a pet', function() {
    
    element.all(by.repeater('pet in pets')).last().click();

    expect(element(by.id('selected'))).toBeTruthy();
    expect(element(by.id('selected')).getText()).toBe(petName);
    
  });

  it('should delete a pet', function() {
    
    element.all(by.repeater('pet in pets')).last().click();
    element(by.id('delete')).click();

    var petList = element.all(by.repeater('pet in pets'));

    expect(petList.last().getText()).not.toContain(petName);
    
  });

});