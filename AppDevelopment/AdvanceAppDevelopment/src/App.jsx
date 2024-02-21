import { BrowserRouter, Routes, Route} from 'react-router-dom'
import { lazy } from 'react'
import LazyLayout from './Components/LazyLayout'
const LazyLogin = lazy(()=> import("./Pages/auth/Login"))
const LazySignup = lazy(()=> import("./Pages/auth/Signup"))
const LazyHome = lazy(() => import("./Pages/User/Home"))
const LazyBooking = lazy(() => import("./Pages/User/Booking"))
import UserLayout from './Pages/User/UserLayout'
const UserRoutes = () => {
  return(
    <UserLayout>
      <Routes>
        <Route path="/home" element={<LazyLayout component={LazyHome}/>}/>
        <Route path="/booking" element={<LazyLayout component={LazyBooking}/>}/>
      </Routes>
    </UserLayout>
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
      </Routes>
    </div>
    
    </BrowserRouter>
   
  )
}

export default App
