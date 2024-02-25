import React from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';

function createData(name, calories, fat, carbs, protein) {
  return { name, calories, fat, carbs, protein };
}

const rows = [
  createData('Gokul', 'cruise', '26-02-2024', '8.00 am', 4000),
  createData('Sriram', 'non cruise', '26-02-2024', '8.00 am', 4300),
  createData('Sundar', 'pantoon', '26-02-2024', '8.00 am', 6000),
  createData('Srihari', 'cruise', '26-02-2024', '8.00 am', 4500),
  createData('Surya', 'pantoon', '26-02-2024', '8.00 am', 3900),
];

const ViewUser = () => {
    return (
        <div >
            <h1>Registered User</h1>
            <div style={{display: 'flex', alignItems: 'center', justifyContent: 'center', alignContent: 'center', marginLeft: '0%'}}>

            <TableContainer component={Paper}>
      <Table sx={{ minWidth: 1000 }} aria-label="simple table">
        <TableHead>
          <TableRow style={{backgroundColor: 'lightgray'}}>
            <TableCell>User Email</TableCell>
            <TableCell align="right">Name</TableCell>
            <TableCell align="right">Phone No</TableCell>
            <TableCell align="right">No of boats booked</TableCell>
            <TableCell align="right">City</TableCell>
            <TableCell align="center">View User</TableCell>
            <TableCell align="center">Edit User</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
              <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
              <TableCell component="th" scope="row">
                {row.name}
              </TableCell>
              <TableCell align="right">{row.calories}</TableCell>
              <TableCell align="right">{row.fat}</TableCell>
              <TableCell align="right">{row.carbs}</TableCell>
              <TableCell align="right">{row.protein}</TableCell>
              <TableCell align="right"><Button variant="contained" color='secondary'>View User</Button></TableCell>
              <TableCell align="right"><Button variant="contained">Edit User</Button></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
          </div>
        </div>   
    )
}

export default ViewUser
