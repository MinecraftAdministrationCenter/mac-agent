import * as fs from "fs"
import * as restify from "restify"
import config from "./app/config/config"
const api = restify.createServer({
    name: config.auth.id
})

// CORS - TODO: handle CORS requests (the restify-cors-middleware and their @types seems to be broken, sadly)
api.use(restify.plugins.fullResponse())

// Other useful restify plugins
api.pre(restify.pre.sanitizePath())
api.use(restify.plugins.acceptParser(api.acceptable))
api.use(restify.plugins.bodyParser())
api.use(restify.plugins.queryParser())
api.use(restify.plugins.authorizationParser())

// The directory that contains all API routes
const routes = `${__dirname}/app/api/routes/`

fs.readdirSync(routes)
    .forEach((fileName: string) => {
        if (fileName.toLowerCase().trim().endsWith(".js")) {
            const route = require(`${routes}/${fileName}`)
            route.register(api)
        }
    })

api.listen(config.port, () => {
    console.log(`Node '${config.auth.id}' is listening on port ${config.port}...`)
})