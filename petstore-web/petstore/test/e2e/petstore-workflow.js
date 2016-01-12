describe('Petstore', function() {

  beforeEach(function() {
    browser.get('http://localhost:9000/#/');
  });

  it('should add a pet', function() {
    
    var petName = 'Pet-'+ Date.now();

    element(by.model('name')).sendKeys(petName);
    element(by.model('status')).sendKeys('Sold');
    element(by.id('add')).click();

    var petList = element.all(by.repeater('pet in pets'));

    expect(petList.last().getText()).toContain(petName);
    
  });
});