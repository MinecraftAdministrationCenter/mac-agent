import Config from "./../models/Config"

const port = (process.env.port && parseInt(process.env.port)) || 2019
const id = process.env.id || "random-uuid-here"

const secret = process.env.secret || "IW€@rMy$unGl@ss3s@N8"

const defaultConfig: Config = {
    port,
    auth: {
        id,
        secret
    }
}

export default defaultConfig