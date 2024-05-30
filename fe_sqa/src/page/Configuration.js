import React, { useEffect, useState } from 'react'
import Header from '../components/Header'
import { Box, Button, FormControl, InputAdornment, InputLabel, OutlinedInput, Typography } from '@mui/material'
import { DatePicker, LocalizationProvider } from '@mui/x-date-pickers'
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'
import dayjs from 'dayjs'
import { toast } from 'react-toastify'

export default function Configuration() {
    const [luongCB, setLuongCB] = useState('');
    const [tiLeHS, setTiLeHS] = useState('');
    const [tiLePhaiDongHS, setTiLePhaiDongHS] = useState('');
    const [tiLeCT, setTiLeCT] = useState('');
    const [tiLeCN, setTiLeCN] = useState('');
    const [tiLeTV1, setTiLeTV1] = useState('');
    const [tiLeTV2, setTiLeTV2] = useState('');
    const [tiLeTV3, setTiLeTV3] = useState('');
    const [tiLeTV4, setTiLeTV4] = useState('');
    const [tiLeTV5, setTiLeTV5] = useState('');
    const [ngayHieuLuc, setNgayHieuLuc] = useState(dayjs().format('YYYY-MM-DD'));
    const [cauHinh, setCauHinh] = useState('');
    const [save, setSave] = useState(true);
    const [listError, setListError] = useState({
        luongCB: "",
        tiLeHS: "",
        tiLePhaiDongHS: "",
        tiLeCT: "",
        tiLeCN: "",
        tiLeTV1: "",
        tiLeTV2: "",
        tiLeTV3: "",
        tiLeTV4: "",
        tiLeTV5: "",
        ngayHL: ""
    });
    useEffect(() => {
        document.title = 'Cấu hình BHYT';
    }, []);
    useEffect(() => {
        console.log(listError.luongCB);
        console.log(listError.tiLeHS);
        console.log(listError.tiLePhaiDongHS);
        console.log(listError.tiLeCT);
        console.log(listError.tiLeCN);
        console.log(listError.tiLeTV1);
        console.log(listError.tiLeTV2);
        console.log(listError.tiLeTV3);
        console.log(listError.tiLeTV4);
        console.log(listError.tiLeTV5);
        console.log(listError.ngayHL);
        if (listError.luongCB !== "" || listError.tiLeHS !== "" || listError.tiLePhaiDongHS !== "" || listError.tiLeCT !== "" || listError.tiLeCN !== "" || listError.tiLeTV1 !== "" || listError.tiLeTV2 !== "" || 
        listError.tiLeTV3 !== "" || listError.tiLeTV4 !== "" || listError.tiLeTV5 !== "" || listError.ngayHL !== "") {
            setSave(false)
        }
        else setSave(true)
    }, [listError])
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/getcauhinh');
                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }
                const jsonData = await response.json();

                setCauHinh(jsonData);
                setLuongCB(jsonData.luongCoBan);
                setTiLeHS(jsonData.tiLeHS);
                setTiLePhaiDongHS(jsonData.tiLePhaiDongHS);
                setTiLeCT(jsonData.tiLeCT);
                setTiLeCN(jsonData.tiLeCN);
                setTiLeTV1(jsonData.tiLeTV1);
                setTiLeTV2(jsonData.tiLeTV2);
                setTiLeTV3(jsonData.tiLeTV3);
                setTiLeTV4(jsonData.tiLeTV4);
                setTiLeTV5(jsonData.tiLeTV5);
                setNgayHieuLuc(jsonData.ngayHieuLuc);
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, []);

    const handleLuongCBChange = (event) => {
        const regex = /^[0-9]*$/;
        var lCB = event.target.value;
        setLuongCB(event.target.value);
        if (lCB.length === 0) {
            setListError({
                ...listError,
                luongCB: "Lương cơ bản không được để trống!",
            });
        }
        else if (regex.test(lCB) === false) {
            setListError({
                ...listError,
                luongCB: "Giá trị lương không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                luongCB: "",
            });
        }
    };

    const handleTiLeHSChange = (event) => {
        setTiLeHS(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeHS: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeHS: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeHS: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeHS: ""
            });
        }
    };

    const handleTiLePhaiDongHSChange = (event) => {
        setTiLePhaiDongHS(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLePhaiDongHS: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLePhaiDongHS: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLePhaiDongHS: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLePhaiDongHS: ""
            });
        }
    };

    const handleTiLeCTChange = (event) => {
        setTiLeCT(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeCT: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeCT: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeCT: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeCT: ""
            });
        }
    };

    const handleTiLeCNChange = (event) => {
        setTiLeCN(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeCN: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeCN: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeCN: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeCN: ""
            });
        }
    };

    const handleTiLeTV1Change = (event) => {
        setTiLeTV1(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeTV1: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeTV1: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeTV1: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeTV1: ""
            });
        }
    };

    const handleTiLeTV2Change = (event) => {
        setTiLeTV2(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeTV2: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeTV2: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeTV2: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeTV2: ""
            });
        }
    };

    const handleTiLeTV3Change = (event) => {
        setTiLeTV3(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeTV3: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeTV3: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeTV3: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeTV3: ""
            });
        }
    };

    const handleTiLeTV4Change = (event) => {
        setTiLeTV4(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeTV4: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeTV4: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeTV4: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeTV4: ""
            });
        }
    };

    const handleTiLeTV5Change = (event) => {
        setTiLeTV5(event.target.value);
        const regex = /^[0-9.]*$/;
        var res = event.target.value;
        if (res.length === 0) {
            setListError({
                ...listError,
                tiLeTV5: "Tỉ lệ không được để trống!",
            });
        }
        else if (res > 100) {
            setListError({
                ...listError,
                tiLeTV5: "Tỉ lệ không được lớn hơn 100%!",
            });
        }
        else if (regex.test(res) === false) {
            setListError({
                ...listError,
                tiLeTV5: "Giá trị tỉ lệ không hợp lệ!",
            });
        }
        else {
            setListError({
                ...listError,
                tiLeTV5: ""
            });
        }
    };

    const handleNgayHieuLucChange = (newDate) => {
        const dateString = newDate ? dayjs(newDate).format('YYYY-MM-DD') : '';
        setNgayHieuLuc(dateString);
        setListError({
            ...listError,
            ngayHL: ""
        })
        console.log(dateString)
    };


    const [response, setResponse] = useState('');

    const handleLuuCauHinh = async () => {
        if(save === true){
            toast.success("Hí hí bạn đã update thành công rồi",
            {
                position: "top-center",
                autoClose: 5000,
                height: 200,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "dark",
            })
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    luongCoBan: luongCB,
                    tiLeHS: tiLeHS,
                    tiLePhaiDongHS: tiLePhaiDongHS,
                    tiLeCT: tiLeCT,
                    tiLeCN: tiLeCN,
                    tiLeTV1: tiLeTV1,
                    tiLeTV2: tiLeTV2,
                    tiLeTV3: tiLeTV3,
                    tiLeTV4: tiLeTV4,
                    tiLeTV5: tiLeTV5,
                    ngayHieuLuc: ngayHieuLuc
                })
            };
            try {
                const res = await fetch('http://localhost:8080/updatecauhinh', requestOptions);
                if (!res.ok) {
                    throw new Error('Network response was not ok');
                }
                const data = await res.json();
                setResponse(data);
                console.log(res)
            } catch (error) {
                console.log(error);
            }
        }
        else{
            toast.error("Hu hu bạn đã update sai rồi",
            {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "dark",
            })
        }
    };

    return (
        <Box style={{
            backgroundColor: 'white',
            width: '100%',
            height: '1000px'
        }}>
            <Box style={{
                position: 'fixed',
                top: 0,
                left: 0,
                width: '100%',
                /* Khoảng cách lề bên trong header */
                zIndex: 1000,
            }}>
                <Header></Header>
            </Box>

            <Box style={{
                paddingTop: '120px',
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
            }}>
                <Box style={{
                    display: 'flex',
                    margin: '30px',
                }}>
                    <Box style={{
                        margin: '30px',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center'
                    }}>
                        <Typography>Học sinh</Typography>
                    </Box>
                    <Box style={{
                        // width: '50%'
                    }}>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '50%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Lương cơ bản</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">đ</InputAdornment>}
                                    label="Amount"
                                    value={luongCB}
                                    onChange={handleLuongCBChange}
                                    defaultValue={luongCB}
                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.luongCB}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '50%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 2 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeHS}
                                    onChange={handleTiLeHSChange}
                                    defaultValue={tiLeHS}
                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeHS}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '50%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ phải đóng</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLePhaiDongHS}
                                    onChange={handleTiLePhaiDongHSChange}
                                    defaultValue={tiLePhaiDongHS}
                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLePhaiDongHS}
                                </Typography>
                            </FormControl>
                        </Box>
                    </Box>
                </Box>

                <Box style={{
                    display: 'flex',
                    margin: '30px',

                }}>
                    <Box style={{
                        margin: '30px',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center'
                    }}>
                        <Typography>Công ty</Typography>
                    </Box>
                    <Box >
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '50%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỷ lệ của công ty</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeCT}
                                    onChange={handleTiLeCTChange}
                                    defaultValue={tiLeCT}
                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeCT}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '50%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ của cá nhân</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeCN}
                                    onChange={handleTiLeCNChange}
                                    defaultValue={tiLeCN}
                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeCN}
                                </Typography>
                            </FormControl>
                        </Box>
                    </Box>
                </Box>
                <Box style={{
                    display: 'flex',
                    margin: '0px',
                }}>
                    <Box style={{
                        margin: '30px',
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center',

                    }}>
                        <Typography>Hộ gia đình</Typography>
                    </Box>
                    <Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Lương cơ bản</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">đ</InputAdornment>}
                                    label="Amount"
                                    value={luongCB}
                                    onChange={handleLuongCBChange}
                                    defaultValue={luongCB}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.luongCB}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeTV1}
                                    onChange={handleTiLeTV1Change}
                                    defaultValue={tiLeTV1}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeTV1}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ người thứ 2</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeTV2}
                                    onChange={handleTiLeTV2Change}
                                    defaultValue={tiLeTV2}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeTV2}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ người thứ 3</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeTV3}
                                    onChange={handleTiLeTV3Change}
                                    defaultValue={tiLeTV3}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeTV3}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ người thứ 4</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeTV4}
                                    onChange={handleTiLeTV4Change}
                                    defaultValue={tiLeTV4}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeTV4}
                                </Typography>
                            </FormControl>
                        </Box>
                        <Box style={{ display: 'flex' }}>
                            <Box style={{
                                width: '70%',
                                display: 'flex',
                                justifyContent: 'center',
                                alignItems: 'center',
                                marginTop: -50
                            }}>
                                <Typography>Tỉ lệ người thứ 5 trở đi</Typography>
                            </Box>
                            <FormControl fullWidth sx={{ m: 1 }}>
                                <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
                                <OutlinedInput
                                    id="outlined-adornment-amount"
                                    startAdornment={<InputAdornment position="start">%</InputAdornment>}
                                    label="Amount"
                                    value={tiLeTV5}
                                    onChange={handleTiLeTV5Change}
                                    defaultValue={tiLeTV5}

                                />
                                <Typography sx={{
                                    height: 50,
                                    width: 200,
                                    color: "red"
                                }}>
                                    {listError.tiLeTV5}
                                </Typography>
                            </FormControl>
                        </Box>
                    </Box>
                </Box>

            </Box>

            <Box style={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                marginTop: '50px'
            }}>
                <Box style={{

                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                    paddingRight: 30
                }}>
                    <Typography>Thời gian bắt đầu có hiệu lực của cấu hình</Typography>
                </Box>
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <DatePicker
                        label="Chọn ngày bắt đầu"
                        minDate={dayjs()}
                        // value={ngayHieuLuc}
                        onChange={handleNgayHieuLucChange}
                    />
                </LocalizationProvider>
            </Box>
            <Box style={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                marginTop: '100px'
            }}>
                <Button variant="contained"
                    onClick={handleLuuCauHinh}>Lưu</Button>
            </Box>
        </Box>
    )
}
