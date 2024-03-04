import React, { useEffect, useState } from 'react'
import Grid from '@mui/material/Unstable_Grid2';
import PersonIcon from '@mui/icons-material/Person';
import Button from '@mui/material/Button';
import '../../assets/css/home.css'
import dayjs from 'dayjs';
import axios from 'axios';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { useParams } from 'react-router-dom';
const Booking2 = () => {
    const [value, setValue] = React.useState(dayjs());
    const [data, setData] = useState([]);
    const type = useParams();
    useEffect(() => {

        console.log(type.id, value.format('YYYY-MM-DD'));
        axios.get(`http://127.0.0.1:8081/ticket/${type.id}/${value.format('YYYY-MM-DD')}`).then(response => {
            setData(response.data);
            console.log(response.data);
        }).catch(error => {
            console.error("Test Error : " ,error);
        })
    },[])

    const handleSearch = () => {
        console.log(type, value.format('YYYY-MM-DD'));
        axios.get(`http://127.0.0.1:8081/ticket/${type.id}/${value.format('YYYY-MM-DD')}`).then(response => {
            setData(response.data);
            console.log(response.data);
        }).catch(error => {
            console.error("Test Error : " ,error);
        })
    }
    return (
        <div>
            <div style={{display: 'flex', alignItems: 'center', justifyContent: 'center'}}>
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <DemoContainer components={['DatePicker']}>
                        <DatePicker label="Pick Date" defaultValue={value} onChange={(newValue) => setValue(newValue)}/>
                    </DemoContainer>
                </LocalizationProvider>
                <Button size="small" onClick={handleSearch}>Search</Button>
            </div>
            {data.map(d => {
                return(

                    <div key={d.id} style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', marginTop: '2.5%', marginBottom: '2.5%' }}>
            
                <div style={{ backgroundColor: 'lightgrey', width: '70%', height: '100%' }}>
                    <Grid container spacing={1}>
                        <Grid item xs={12} sm={6} md={4} style={{minWidth: '300px'}}>
                            <img src="/src/assets/Images/boat2.jpg" alt="Description of the image" style={{ width: '100%', height: '100%' }} />
                        </Grid>
                        <Grid item xs={12} sm={6} md={8} style={{minWidth: '300px'}}>
                            <Grid container spacing={2} direction="row">
                                <Grid item xs={4} style={{minWidth: '200px'}}>
                                <div>
                                <div style={{fontSize: '24px', padding: '5.5%', fontFamily: 'Graphik-Semibold,sans-serif'}}>
                                    <h2>{d.boattype}</h2>
                                </div>
                                <div style={{marginTop: '5%'}}>
                                    <div style={{display: 'flex', padding: '5.5%'}}>
                                        <PersonIcon/>
                                        <h3>{d.avail} left</h3> 
                                    </div>
                                    <div style={{display: 'flex', padding: '5.5%'}}>
                                        <PersonIcon/>
                                        <h3>{d.capacity} Capacity</h3> 
                                    </div>
                                </div>
                                <div style={{marginTop: '5%', padding: '5.5%'}}>
                                    <h3>Date:</h3>
                                    <h4>{d.date}</h4>
                                </div>
                            </div>
                                </Grid>
                                <Grid item xs={4} style={{minWidth: '100px', marginLeft: '50%'}}>
                                <div>
                                <div style={{fontSize: '15px',padding: '5.5%', fontFamily: 'Graphik-Semibold,sans-serif', marginTop: '15%'}}>
                                    <h2>Rs. {d.price}</h2>
                                </div>
                                <div style={{marginTop: '5%'}}>
                                    <div style={{display: 'flex', padding: '5.5%'}}>
                                        {/* <PersonIcon/> */}
                                        <h4>Per Day</h4>
                                        {/* <p>Excludes taxes and fees</p> */}
                                    </div>
                                </div>
                                <div style={{marginTop: '5%', padding: '5.5%'}}>
                                    {/* <h3>Description:</h3> */}
                                    <Button  variant="contained">Book Now</Button>
                                </div>
                            </div>
                                </Grid>
                            </Grid>
                        </Grid>
                    </Grid>
                </div>
            </div>
            
            
            )
        })}
        </div>
    )
}

export default Booking2
