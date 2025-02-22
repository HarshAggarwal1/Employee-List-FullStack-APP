import React, { useState, useEffect } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

const CreateEmployeeComponent = () => {
    const { id } = useParams();
    const history = useHistory();
    const [employee, setEmployee] = useState({
        firstName: '',
        lastName: '',
        emailId: ''
    });

    useEffect(() => {
        if (id !== '_add') {
            EmployeeService.getEmployeeById(id).then((res) => {
                let employee = res.data;
                setEmployee({
                    firstName: employee.firstName,
                    lastName: employee.lastName,
                    emailId: employee.emailId
                });
            });
        }
    }, [id]);

    const saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        if (id === '_add') {
            EmployeeService.createEmployee(employee).then(() => {
                history.push('/employees');
            });
        } else {
            EmployeeService.updateEmployee(employee, id).then(() => {
                history.push('/employees');
            });
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployee((prevState) => ({
            ...prevState,
            [name]: value
        }));
    };

    const cancel = () => {
        history.push('/employees');
    };

    const getTitle = () => {
        return id === '_add' ? <h3 className="text-center">Add Employee</h3> : <h3 className="text-center">Update Employee</h3>;
    };

    return (
        <div>
            <br />
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        {getTitle()}
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> First Name: </label>
                                    <input
                                        placeholder="First Name"
                                        name="firstName"
                                        className="form-control"
                                        value={employee.firstName}
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="form-group">
                                    <label> Last Name: </label>
                                    <input
                                        placeholder="Last Name"
                                        name="lastName"
                                        className="form-control"
                                        value={employee.lastName}
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="form-group">
                                    <label> Email Id: </label>
                                    <input
                                        placeholder="Email Address"
                                        name="emailId"
                                        className="form-control"
                                        value={employee.emailId}
                                        onChange={handleChange}
                                    />
                                </div>

                                <button className="btn btn-success" onClick={saveOrUpdateEmployee}>
                                    Save
                                </button>
                                <button className="btn btn-danger" onClick={cancel} style={{ marginLeft: '10px' }}>
                                    Cancel
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default CreateEmployeeComponent;
