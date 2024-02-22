import React from 'react'
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

import ProfileCover from '../../assets/Images/home2.jpg'
import { reload } from '@firebase/auth';
const ProfileCardWidget =()=> {
    return (
        <div>
            {/* <h1>ProfileCardWidget</h1> */}
            <Card border="light" className="text-center p-0 mb-4" style={{display: 'flex'}}>
            <div style={{ backgroundImage: `url(${ProfileCover})` }}  className="profile-cover rounded-top" />
            <Card sx={{ maxWidth: 345 }}>
                <CardMedia
                    sx={{ height: 140 }}
                    image="/src/assets/Images/boat1.png"
                    title="green iguana"
                />
                <div className='image' style={{height: "120px", width: '120px', backgroundImage: "url('/src/assets/Images/gta.jpeg')", borderRadius: "50%", position: 'relative', left: '32%', bottom: '60px', zIndex: '5'}}/>
                <div style={{position: 'relative', bottom: '70px'}}>

                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                    Lizard
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                    Lizards are a widespread group of squamate reptiles, with over 6,000
                    species, ranging across all continents except Antarctica
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small" variant='contained'>Update Profile Pic</Button>
                    <Button size="small" variant='contained'>Update Cover Pic</Button>
                </CardActions>
                </div>
                </Card>
            </Card>
        </div>
    )
}

export default ProfileCardWidget
