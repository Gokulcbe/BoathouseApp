import propTypes from 'prop-types'
import Navbar from '../../Components/Navbar'
import '../../assets/css/home.css'
const UserLayout = ({children}) => {
    return (
        // <div className="image-bg" style={{width: "100%", marginTop: "0%"}}>
        <div>
            <video className="video-bg" autoPlay loop muted>
            <source src="/node_modules/home.mp4" type="video/mp4" />
        </video>
            <header>
                <Navbar/>
            </header>
            <main>
                {children}
            </main>
            <footer>
                {/* <h1>Footer</h1> */}
            </footer>
        </div>
    )
}

UserLayout.propTypes = {
    children : propTypes.node.isRequired
}

export default UserLayout