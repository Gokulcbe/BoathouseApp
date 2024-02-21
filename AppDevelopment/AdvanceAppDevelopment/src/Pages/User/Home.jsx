// import React from 'react'
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';

const Home = () => {
    return (
        <div className="home-container">
            <h1>Welcome to Boat House Booking</h1>
            <div style={{display: 'flex'}}>

            <Grid className="grid-container" container rowSpacing={1} columnSpacing={{ xs: 6, sm: 6, md: 6 }}>
                {/* <div  className="grid"> */}

                <Grid className='grid1' item xs={3}>
                    <img style={{height: '100%', width: '100%'}} src="/src/assets/Images/home1resize.png" alt="Description of the image" />
                    <h1>Search Simply</h1>
                    <h4>Search through 100s of BoatHouse in just a few seconds.</h4>
                </Grid>
                <Grid className='grid2' item xs={3}>
                    <img style={{height: '100%', width: '100%'}} src="/src/assets/Images/homepage2resize.png" alt="Description of the image" />
                    <h1>Quality Service</h1>
                    <h4>Experiece our impeckable service & quality of our Boathouses</h4>
                </Grid>
                <Grid className='grid3' item xs={3}>
                    <img style={{height: '100%', width: '100%'}} src="/src/assets/Images/homepage3resize.png" alt="Description of the image" />
                    <h1>Save big</h1>
                    <h4>Discover a great deal to book on our site and get unbeatable discounts</h4>
                </Grid>
                {/* </div> */}
            </Grid>
            </div>
        </div>
    )
}

export default Home
