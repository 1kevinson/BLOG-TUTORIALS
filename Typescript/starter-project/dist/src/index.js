"use strict";
const java = 'JAVA';
const javascript = 'JAVASCRIPT';
function getFavouriteLanguage(answer) {
    switch (answer.toUpperCase()) {
        case java.toString():
            return `Your favourite language is ${java}`;
        case javascript.toString():
            return `Your favourite language is ${javascript}`;
        default:
            return 'wrong language...';
    }
}
module.exports = getFavouriteLanguage;
//# sourceMappingURL=index.js.map