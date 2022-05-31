"use strict";
const getLanguage = require('../src/index');
describe('TEST JEST TYPESCRIPT', () => {
    test('should returns JAVA for answer = java', () => {
        expect(getLanguage('java'))
            .toBe('Your favourite language is JAVA');
    });
    test('should returns JAVASCRIPT for answer = javascript', () => {
        expect(getLanguage('javascript'))
            .toBe('Your favourite language is JAVASCRIPT');
    });
    test('should returns Wrong language for answer different to java | javascript', () => {
        expect(getLanguage('python'))
            .toBe('wrong language...');
    });
});
//# sourceMappingURL=index.spec.js.map