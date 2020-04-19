var label = ['strong'];
label.forEach(e => {
    var _regex = '(?<=(<' + e + '>))[^(<' + e + '>)(</' + e + '>)]*(?=(</' + e + '>))';
})
