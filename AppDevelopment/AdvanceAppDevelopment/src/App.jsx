import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import { lazy } from 'react'
import LazyLayout from './Components/LazyLayout'
const LazyLogin = lazy(()=> import("./Pages/auth/Login"))
const LazySignup = lazy(()=> import("./Pages/auth/Signup"))
const LazyHome = lazy(() => import("./Pages/User/Home"))
const LazyBooking = lazy(() => import("./Pages/User/Booking"))
const LazyProfile = lazy(() => import("./Pages/User/Profile"))
import UserLayout from './Pages/User/UserLayout'
import Footer from './Components/Footer'
import { Element } from "react-scroll";
const LazyAbout = lazy(() => import("./Pages/User/About"))
import Grid from '@mui/material/Grid';
const LazyContact = lazy(() => import("./Pages/User/Contact"))
import AdminLayout from './Pages/admin/AdminLayout'
// import AdminHome from './Pages/admin/AdminHome'
const LazyAdmin = lazy(() => import("./Pages/admin/Admin"))
const LaztAdminHome = lazy(()=> import("./Pages/admin/AdminHome"))

const UserRoutes = () => {
  return(
    <UserLayout>
      <Routes>
        <Route path="/home" element={<Element name="home-section">
                    <Home />
                  </Element>}/>
        {/* <Route path="/home" element={<LazyLayout component={LazyHome}/>}/> */}
        <Route path="/booking" element={<LazyLayout component={LazyBooking}/>}/>
        <Route path="/profile" element={<LazyLayout component={LazyProfile}/>}/>
        <Route path="/about" element={<LazyLayout component={LazyAbout}/>}/>
        <Route path="/contact" element={<LazyLayout component={LazyContact}/>}/>
        <Route path="/Logout" element={<Navigate to="/"/>}/>
      </Routes>
      <Footer/>
    </UserLayout>
  )
}

const AdminRoutes = () => {
  return (
    <AdminLayout>
    <Routes>
      <Route path="/home" element={<LazyLayout component={LazyAdmin}/>}/>
    </Routes>
  </AdminLayout>
)
}
function App() {
  // const [count, setCount] = useState(0)

  return (
    <BrowserRouter>
    <div className='App'>
      <Routes>
        <Route path="/" element={<LazyLayout component={LazyLogin}/>}/>
        <Route path="/signup" element={<LazyLayout component={LazySignup}/>}/>
        <Route path="/user/*" element={<UserRoutes/>}/>
        <Route path="/admin/*" element={<AdminRoutes/>}/>
      </Routes>
      
    </div>
    
    </BrowserRouter>
   
  )
}

const Home = () => {
  return(
    <>
      <LazyHome/>
      <LazyAbout/>
      <LazyContact/>
    </>
  )
}


export default App
