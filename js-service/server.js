var express = require('express')
var app = express()
var port = process.env.PORT || 8080

app.route('/').get(function(req, res) {
	res.json({ "status": "healthy" })
})

app.listen(port)

console.log('Server started on port ' + port)