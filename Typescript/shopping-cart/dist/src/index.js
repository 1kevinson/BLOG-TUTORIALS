const java = 'JAVA';
const javascript = 'JAVASCRIPT';
export function getFavouriteLanguage(answer) {
    switch (answer.toUpperCase()) {
        case java.toString():
            return `Your favourite language is ${java}`;
        case javascript.toString():
            return `Your favourite language is ${javascript}`;
        default:
            return 'wrong language...';
    }
}
//# sourceMappingURL=index.js.map